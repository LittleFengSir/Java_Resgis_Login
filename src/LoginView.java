import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class LoginView extends JFrame {

    //创建布局管理器
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();

    LoginHandle loginHandle = new LoginHandle(this);
    JLabel nameLabel = new JLabel("登录",JLabel.CENTER);
    JLabel userNameLabel = new JLabel("用户名");
    JTextField userNameJTextField =  createRestrictedTextField();
    JLabel pwdLabel = new JLabel("密码");
    JPasswordField pwdField = new JPasswordField(20);

    JButton loginBtn = new JButton("登录");
    JButton regBtn = new JButton("注册");


    public LoginView() {
        super("登录/注册");
        setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        nameLabel.setFont(new Font("975Maru SC",Font.BOLD,36));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        add(nameLabel,gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(userNameLabel,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        add(userNameJTextField,gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(pwdLabel,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        add(pwdField,gridBagConstraints);

        loginBtn.addActionListener(loginHandle.loginBtnListener);
        gridBagConstraints.gridy = 3;
        add(loginBtn,gridBagConstraints);
        regBtn.addActionListener(loginHandle.regBtnListener);
        gridBagConstraints.gridy = 4;
        add(regBtn,gridBagConstraints);

        URL imgUrl = LoginView.class.getClassLoader().getResource("logo.png");
        setIconImage(new ImageIcon(imgUrl).getImage());
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    //只能输入英文字母和_的文本框
    public  JTextField createRestrictedTextField(){
        JTextField textField = new JTextField(20);
        PlainDocument doc = (PlainDocument) textField.getDocument();
        doc.setDocumentFilter(new MyDocumentFilter());
        return textField;
    }

    static class MyDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string.matches("[a-zA-Z0-9_]+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text.matches("[a-zA-Z0-9_]+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    public JTextField getUserNameJTextField() {
        return userNameJTextField;
    }

    public JPasswordField getPwdField() {
        return pwdField;
    }

    public static void main(String[] args) {
        new LoginView();
    }
}
