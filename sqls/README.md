# Database initialisation scripts

The repository ships the canonical RuoYi-Cloud database schema in this folder so
that an operator can initialise MySQL with one command:

```bash
mysql -uroot -p < sqls/ry-cloud.sql
mysql -uroot -p < sqls/quartz.sql
```

`ry-cloud.sql` aggregates the main business tables, the system/role/menu/user
relations, code-generator tables and so on. `quartz.sql` is the schedule job
schema (the local `@Scheduled` jobs in `ruoyi-job` do not need it, but
`ruoyi-xxl-job-admin` or the legacy RuoYi 4.x scheduler do).

These files are intentionally checked in to satisfy the requirement:

> 数据库初始化脚本放在仓库下的 sqls 里面
