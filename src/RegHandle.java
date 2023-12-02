import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegHandle {
    private RegisterView registerView;
    public RegHandle(RegisterView registerView){
        this.registerView = registerView;
    }
    ActionListener registerButton = new ActionListener() {
        public void actionPerformed(ActionEvent e){
            boolean errorFlag = false;
            String userNameInput = registerView.getUserTextField().getText();
            char[] pwdInput = registerView.getPwdField().getPassword();
            char[] pwd1Input = registerView.getPwdField2().getPassword();
            String pwdString = new String(pwdInput);
            String pwd1String = new String(pwd1Input);
            String yzmInput = registerView.getCapTextField().getText();
            String yzm = registerView.getCodeGenerator().getGeneratedCode();
            if(!(pwdString.equals(pwd1String))){
                JOptionPane.showMessageDialog(null, "密码不一致，请重新输入。", "密码错误", JOptionPane.ERROR_MESSAGE);
                registerView.getPwdField().setText("");
                registerView.getPwdField2().setText("");
                registerView.getCapTextField().setText("");
                errorFlag = true;
            }
            else if(userNameInput.isEmpty() || pwdString.isEmpty()){
                JOptionPane.showMessageDialog(null, "用户名或密码不能为空", "ERROR", JOptionPane.ERROR_MESSAGE);
                errorFlag = true;
            }
            else if(!(yzmInput.equals(yzm))){
                JOptionPane.showMessageDialog(null, "输入的验证码错误", "验证码错误", JOptionPane.ERROR_MESSAGE);
                registerView.getCapTextField().setText("");
                errorFlag = true;
            }
            if(!errorFlag){
                UserData.userName = userNameInput;
                UserData.userPWd = pwdString;
                JOptionPane.showMessageDialog(null, "注册成功！");
                registerView.dispose();
            }

        }
    };

}
