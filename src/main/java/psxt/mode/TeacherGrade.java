package psxt.mode;

import java.util.List;

import lombok.Data;

@Data
public class TeacherGrade {
private User user;
private List<User> group;//该专家的所在分组的所有学校
private List<User> unscore;//未打分列表
}
