#!/usr/bin/env bash
# Lightweight Maven launcher.
# If `mvn` is on the PATH, just delegate. Otherwise print a clear
# install hint; this is a 60-second stub.
set -e
if command -v mvn >/dev/null 2>&1; then
  exec mvn "$@"
fi
echo "Apache Maven (mvn) is not installed." >&2
echo "Install one of:" >&2
echo "  - apt:        sudo apt install maven" >&2
echo "  - dnf:        sudo dnf install maven" >&2
echo "  - brew:       brew install maven" >&2
echo "  - manual:     https://maven.apache.org/download.cgi" >&2
exit 127
