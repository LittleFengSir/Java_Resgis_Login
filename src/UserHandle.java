import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserHandle {
    private final UserPanel userPanel;
    public UserHandle(UserPanel userPanel){
        this.userPanel = userPanel;
    }
    ActionListener changePWDBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ChangeView();
            userPanel.dispose();
        }
    };
    ActionListener exitBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new LoginView();
            userPanel.dispose();
        }
    };
}
