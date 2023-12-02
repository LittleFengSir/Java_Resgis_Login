import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserPanel extends JFrame {
    public UserPanel(){
        super("用户菜单");

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);
        UserHandle userHandle = new UserHandle(this);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JLabel nameLabel = new JLabel("用户菜单");
        JButton changePWD = new JButton("修改密码");
        JButton exitButton = new JButton("退出登录");

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        nameLabel.setFont(new Font("975Maru SC",Font.BOLD,36));
        add(nameLabel,gridBagConstraints);

        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        changePWD.addActionListener(userHandle.changePWDBtnListener);
        add(changePWD,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        exitButton.addActionListener(userHandle.exitBtnListener);
        add(exitButton,gridBagConstraints);


        setLocationRelativeTo(null);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UserPanel();
    }

}
