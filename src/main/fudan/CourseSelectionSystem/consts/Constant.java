package main.fudan.CourseSelectionSystem.consts;

public class Constant {
    /* 默认密码 */
    public static final String DEFAULT_PASSWORD = "123456";
    /* 教师权限 */
    public static final String PERM_TEACHER = "Teacher";
    /* 学生权限 */
    public static final String PERM_STUDENT = "Student";
    /* 管理员权限 */
    public static final String PERM_MANAGER = "Manager";
    /* 拦截前的界面 */
    public static final String SESSION_BLOCK_PAGE = "block_page";
    /* 用户字段 */
    public static final String SESSION_USER = "user";
    /* 用户权限字段 */
    public static final String SESSION_PERMISSION = "permission";
    /* 选课事务申请常数 */
    public static final String REQ_UNHANDLE = "unhandle";
    public static final String REQ_PASS = "pass";
    public static final String REQ_FAIL = "fail";
    /* 每种类型的用户的主页 */
    public static final String HOME_STUDENT_PAGE = "studentHome";
    public static final String HOME_TEACHER_PAGE = "teacherHome";
    public static final String HOME_MANAGER_PAGE = "managerHome";
    public static final String PAGES_STUDENT = "studentUrls";
    public static final String PAGES_TEACHER = "teacherUrls";
    public static final String PAGES_MANAGER = "managerUrls";
    public static final String HOME_STUDENT = "/jsp/student_mygrade.jsp";
    public static final String HOME_TEACHER = "/jsp/teacher_mycourse.jsp";
    public static final String HOME_MANAGER = "/jsp/manager_main.jsp";
}
