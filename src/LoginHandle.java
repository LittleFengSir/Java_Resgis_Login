import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginHandle extends JFrame{
    private LoginView loginView;
    public LoginHandle(LoginView loginView){
        this.loginView = loginView;
    }
    ActionListener regBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterView registerView = new RegisterView();
            registerView.setVisible(true);
        }

    };
    ActionListener loginBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean errorFlag = false;
            String userNameInput = loginView.getUserNameJTextField().getText();
            char[] pwdInput = loginView.getPwdField().getPassword();
            String pwdString = new String(pwdInput);
            if(!userNameInput.equals(UserData.userName) || !pwdString.equals(UserData.userPWd)){
                JOptionPane.showMessageDialog(null, "用户名或密码错误", "ERROR", JOptionPane.ERROR_MESSAGE);
                errorFlag = true;
            }
            if(!errorFlag){
                JOptionPane.showMessageDialog(null, "登录成功！");
                UserPanel userPanel = new UserPanel();
                loginView.dispose();
            }
        }
    };

}
