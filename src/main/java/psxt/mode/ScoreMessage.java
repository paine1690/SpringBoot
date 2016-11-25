package psxt.mode;

import lombok.Data;
/**
 * 这个类主要是用于专家查看学校分数和显示学校分数的
 * @author lh
 *
 */
@Data
public class ScoreMessage {
private int id;
private String school;
private String dir;
private int score;
}
