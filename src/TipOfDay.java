import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;

public class TipOfDay extends JDialog {

    public TipOfDay () {
        initGUI();
    }

    private void initGUI() {
        var basePanel = new JPanel();
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        add(basePanel);

        var topPanel = new JPanel(new BorderLayout(0, 0));
        topPanel.setMaximumSize(new Dimension(450, 0));

        var hint = new JLabel("Production Hints");
        hint.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        topPanel.add(hint);

        var seperator = new JSeparator();
        seperator.setForeground(Color.gray);

        topPanel.add(seperator, BorderLayout.SOUTH);

        basePanel.add(topPanel);

        var textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        var pane = new JTextPane();
        pane.setContentType("text/html");
        String text = "<p><b>Closing windows using the mouse wheel</b></p>" +
                "<p>Clicking with the mouse wheel on an editor tab closes the window. " +
                "This method works also with dockable windows or Log window tabs.</p>";
        pane.setText(text);
        pane.setEditable(false);
        textPanel.add(pane);

        basePanel.add(textPanel);

        var boxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));

        var box = new JCheckBox("Show tips at startup");

        boxPanel.add(box);
        basePanel.add(boxPanel);

        var bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        var tipbtn = new JButton("Next Tip");
        var closebtn = new JButton("close");

        bottomPanel.add(tipbtn);
        bottomPanel.add(closebtn);

        basePanel.add(bottomPanel);

        bottomPanel.setMaximumSize(new Dimension(450, 0));

        setTitle("Tip of the Day");
        setSize(new Dimension(450, 350));
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new TipOfDay();
            ex.setVisible(true);
        });
    }


}
