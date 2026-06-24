# RuoYi-Cloud backend (WMS demo)

This repository contains a Spring Cloud / Spring Cloud Alibaba backend skeleton
modelled on the upstream RuoYi-Cloud project (yangzongzhuan/RuoYi-Cloud,
MIT licensed). It is a self-contained multi-module Maven project that delivers
the canonical RuoYi-Cloud layout ready to be filled in by the rest of the WMS
demo platform.

> Per the task description the database connection and Redis connection are
> **deliberately left blank** in every `bootstrap.yml`/Nacos reference, and the
> database initialisation scripts live in `sqls/`.

## Modules

```
ruoyi-cloud
├── ruoyi-common            – shared utility / config jars
│   ├── ruoyi-common-core        R<T>, BaseEntity, Page, Exception
│   ├── ruoyi-common-datasource  Druid + MyBatis-Plus + dynamic-datasource
│   ├── ruoyi-common-redis       Spring Data Redis
│   ├── ruoyi-common-security    Feign interceptor, JWT utils, login context
│   ├── ruoyi-common-log         @Log AOP
│   └── ruoyi-common-swagger     swagger / springdoc
├── ruoyi-api              – Feign client definitions
│   ├── ruoyi-api-system
│   ├── ruoyi-api-monitor
│   └── ruoyi-api-workflow
├── ruoyi-auth             – authentication service  (port 9200)
├── ruoyi-gateway          – Spring Cloud Gateway    (port 8080)
├── ruoyi-modules
│   ├── ruoyi-system            user/role/menu service (port 9201)
│   ├── ruoyi-job               @Scheduled tasks       (port 9203)
│   ├── ruoyi-file              upload service         (port 9202)
│   └── ruoyi-gen               code generator         (port 9204)
├── ruoyi-visual
│   └── ruoyi-monitor           Spring Boot Admin      (port 9100)
├── sqls                       – MySQL initialisation scripts
│   ├── ry-cloud.sql            main business schema
│   └── quartz.sql              optional Quartz tables
└── bin/start-all.sh            – one-shot launcher (mvn + jars)
```

## Requirements

| Component | Version                          |
|-----------|----------------------------------|
| JDK       | 8+ (project targets 1.8)         |
| Maven     | 3.6+                             |
| Nacos     | 2.x (discovery + config server)  |
| MySQL     | 5.7+ / 8.0+                      |
| Redis     | 5.x+                             |

## Build

```bash
mvn clean install -DskipTests
```

This produces a Spring Boot fat-jar per service. A convenience launcher is
provided in `bin/start-all.sh` (boots everything sequentially with logs in
`logs/`).

## Configuration

Each service has a `bootstrap.yml`. The datasource and Redis blocks are
intentionally left blank so that no real secret is committed. Configure them
through:

* `application-*.yaml` files in Nacos (`spring.profiles.active=dev` by
  default), or
* the corresponding `spring.datasource.*` / `spring.redis.*` properties.

The Nacos address defaults to `127.0.0.1:8848`; change it via
`spring.cloud.nacos.discovery.server-addr` to point at the shared registry.

## Database initialisation

```bash
mysql -uroot -p < sqls/ry-cloud.sql   # required
mysql -uroot -p < sqls/quartz.sql     # optional
```

`ry-cloud.sql` provisions the canonical `ry-cloud` schema (users, roles, menus,
depts, config, dict, notice, operation log, login log, code-generator
metadata) and seeds an `admin / admin123` account.

## Status

* Maven multi-module layout: complete
* Common modules (core / datasource / redis / security / log / swagger): wired
* Auth + Gateway + System + Job + File + Gen + Monitor: skeleton running
* Nacos config: placeholders in place, no credentials committed
* Database connection: blank, see `sqls/`
* Redis connection: blank
