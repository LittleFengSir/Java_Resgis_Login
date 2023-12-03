import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class ChangeHandle {
    private final ChangeView changeView;
    private final PasswordHasher passwordHasher = new PasswordHasher();
    public ChangeHandle(ChangeView changeView){
        this.changeView = changeView;
    }
    ActionListener confirmBtnListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean errorFlag = false;
            boolean passwordMatch = passwordHasher.verifyPassword(new String(changeView.getOriginalPWDField().getPassword()),UserData.salt,UserData.userPWd);
                if (!changeView.getUserNameField().getText().equals(UserData.userName) || !passwordMatch){
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
                    byte[] salt = passwordHasher.generateSalt();
                    UserData.userPWd = passwordHasher.hashPassword(new String(changeView.getNewPWDField().getPassword()),salt);
                    UserData.salt = salt;
                     JOptionPane.showMessageDialog(null, "修改成功！");
                     changeView.dispose();
                     new LoginView();
                 }
        }
    };
}
