#!/usr/bin/env bash
# Start every ruoyi-cloud service sequentially.
# Each jar is started in the background; tail -f logs/<service>.log to watch.
set -e

ROOT=$(cd "$(dirname "$0")/.." && pwd)
cd "$ROOT"
mkdir -p logs

declare -a SERVICES=(
  "ruoyi-gateway:8080"
  "ruoyi-auth:9200"
  "ruoyi-system:9201"
  "ruoyi-file:9202"
  "ruoyi-job:9203"
  "ruoyi-gen:9204"
  "ruoyi-monitor:9100"
  "ruoyi-wms:9205"
)

mvn -q -DskipTests install
echo "Build complete."

for entry in "${SERVICES[@]}"; do
  name=${entry%%:*}
  port=${entry##*:}
  jar="$ROOT/$name/target/$name.jar"
  if [[ ! -f $jar ]]; then
    echo "WARN: jar not found for $name, skipping" >&2
    continue
  fi
  echo "Starting $name on port $port ..."
  nohup java -Xms256m -Xmx512m -jar "$jar" \
    --server.port="$port" \
    > "logs/$name.log" 2>&1 &
  echo "$name pid=$!"
done

echo "All services launched. See logs/."
