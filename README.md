## 平台简介
   基于hplus和inspinia两套后台系统模板开发
## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql)支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 在线构建器：拖动表单元素生成相应的HTML代码。
17. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。


## 统计学生考勤信息
SELECT class_id,teacher_id,attendance_datetime,classroom,lesson,sum(attendancenum) as attendancenum ,sum(studentnum)  as studentnum  from  
(
SELECT class_id,teacher_id,attendance_datetime,classroom,lesson,count(0) as studentnum,0 as attendancenum
from teach_attendance ta
join teach_student_attendance tsa on
ta.attendance_id = tsa.attendance_id 
-- WHERE DATEDIFF(ta.attendance_datetime,NOW())=-1
GROUP BY  ta.class_id,ta.lesson,ta.teacher_id
UNION  
select class_id,teacher_id,attendance_datetime,classroom,lesson,0 as studentnum,count(attendance) as attendancenum  from teach_attendance ta
join teach_student_attendance tsa on
ta.attendance_id = tsa.attendance_id 
where tsa.attendance = '1'
-- and DATEDIFF(ta.attendance_datetime,NOW())=-1
GROUP BY  ta.class_id,ta.lesson,ta.teacher_id
) a 
GROUP BY  a.class_id,a.teacher_id,a.attendance_datetime,a.classroom,a.lesson




