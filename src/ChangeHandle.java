import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class ChangeHandle {
    private final ChangeView changeView;
    public ChangeHandle(ChangeView changeView){
        this.changeView = changeView;
    }
    ActionListener confirmBtnListener = new ActionListener() {
        boolean errorFlag = false;
        @Override
        public void actionPerformed(ActionEvent e) {
                 if (!changeView.getUserNameField().getText().equals(UserData.userName) || !new String(changeView.getOriginalPWDField().getPassword()).equals(UserData.userPWd)){
                     JOptionPane.showMessageDialog(null, "用户名或密码错误", "ERROR", JOptionPane.ERROR_MESSAGE);
                     errorFlag = true;
                 } else if (!Arrays.equals(changeView.getNewPWDField().getPassword(), changeView.getNewPWDField1().getPassword())) {
                     JOptionPane.showMessageDialog(null, "两次密码不一样，请重新输入", "ERROR", JOptionPane.ERROR_MESSAGE);
                     errorFlag = true;
                 } else if (!changeView.getYzmField().getText().equals(changeView.codeGenerator.getGeneratedCode())) {
                     JOptionPane.showMessageDialog(null, "验证码错误", "ERROR", JOptionPane.ERROR_MESSAGE);
                     errorFlag = true;
                 }
                 if (!errorFlag){
                    UserData.userName = changeView.getUserNameField().getText();
                    UserData.userPWd = new String(changeView.getNewPWDField().getPassword());
                     JOptionPane.showMessageDialog(null, "修改成功！");
                     changeView.dispose();
                     new LoginView();
                 }
        }
    };
}
