import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChangeView extends JFrame {
    RandomCodeGenerator codeGenerator = new RandomCodeGenerator();
        JLabel nameLabel = new JLabel("修改密码");
        JLabel userNameLabel = new JLabel("用户名");
        JTextField userNameField = new JTextField(20);
        JLabel originalPWDLabel = new JLabel("原密码");
        JPasswordField originalPWDField = new JPasswordField(20);
        JLabel newPWDLabel = new JLabel("新密码");
        JPasswordField newPWDField = new JPasswordField(20);
        JLabel newPWDLabel1 = new JLabel("确认新密码");
        JPasswordField newPWDField1 = new JPasswordField(20);
        JLabel yzmLabel = new JLabel("验证码");
        JTextField yzmField = new JTextField(20);
        JLabel yzmTipsLabel = new JLabel("输入验证码(点击刷新)");
        public ChangeView(){
            super("修改密码");

            GridBagLayout gridBagLayout = new GridBagLayout();
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            setLayout(gridBagLayout);
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.insets = new Insets(5,5,5,5);
            codeGenerator.generateCode();
            JLabel yzmShow = new JLabel(codeGenerator.getGeneratedCode(), SwingConstants.CENTER);
            JButton confirmButton = new JButton("确认");
            ChangeHandle changeHandle = new ChangeHandle(this);
            yzmShow.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    codeGenerator.generateCode();
                    yzmShow.setText(codeGenerator.getGeneratedCode());
                }
            });
            nameLabel.setFont(new Font("975Maru SC", Font.BOLD,36));
            confirmButton.addActionListener(changeHandle.confirmBtnListener);
            ChangeViewLayoutSettings(gridBagConstraints, yzmShow, confirmButton);

            setLocationRelativeTo(null);
            setSize(600,400);

            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    private void ChangeViewLayoutSettings(GridBagConstraints gridBagConstraints, JLabel yzmShow, JButton confirmButton) {
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(userNameLabel, gridBagConstraints);
        gridBagConstraints.gridy = 2;
        add(originalPWDLabel, gridBagConstraints);
        gridBagConstraints.gridy = 3;
        add(newPWDLabel, gridBagConstraints);
        gridBagConstraints.gridy = 4;
        add(newPWDLabel1, gridBagConstraints);
        gridBagConstraints.gridy = 5;
        add(yzmLabel, gridBagConstraints);
        gridBagConstraints.gridy = 6;
        add(yzmTipsLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(userNameField, gridBagConstraints);
        gridBagConstraints.gridy = 2;
        add(originalPWDField, gridBagConstraints);
        gridBagConstraints.gridy = 3;
        add(newPWDField, gridBagConstraints);
        gridBagConstraints.gridy = 4;
        add(newPWDField1, gridBagConstraints);
        gridBagConstraints.gridy = 5;
        add(yzmShow, gridBagConstraints);
        gridBagConstraints.gridy = 6;
        add(yzmField, gridBagConstraints);
        gridBagConstraints.gridy = 7;
        add(confirmButton, gridBagConstraints);
    }

    public JTextField getUserNameField() {
        return userNameField;
    }

    public JPasswordField getOriginalPWDField() {
        return originalPWDField;
    }

    public JPasswordField getNewPWDField() {
        return newPWDField;
    }

    public JPasswordField getNewPWDField1() {
        return newPWDField1;
    }

    public JTextField getYzmField() {
        return yzmField;
    }

    public static void main(String[] args) {
        new ChangeView();
    }

}
