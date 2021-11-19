import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class main extends JFrame {

    private JLabel coords;

    public main() {
        initUI();
    }

    private void initUI() {
        createMenuBar();

        var bottomPanel = new JPanel(new BorderLayout());
        var topPanel = new JPanel();

        topPanel.setBackground(Color.gray);
        topPanel.setPreferredSize(new Dimension(250, 150));
        bottomPanel.add(topPanel);

        bottomPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        add(bottomPanel);

        pack();

        /*var quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));
        quitButton.setToolTipText("click me.");
        createLayout(quitButton); */

        coords = new JLabel();

        createLayout(coords);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                int x = e.getX();
                int y = e.getY();

                var text = String.format("x: %d, y: %d", x, y);

                coords.setText(text);
            }
        });

        setTitle("A simple gui");
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {
        var menuBar = new JMenuBar();

        var fileMenu = new JMenu("File");
        var viewMenu = new JMenu("View");

        var openMenuItem = new JMenuItem("Open");
        openMenuItem.setToolTipText("Open a file");
        var exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);

        var showMousePosText = new JCheckBoxMenuItem("Show statusbar");
        showMousePosText.setSelected(true);

        showMousePosText.addItemListener((event) -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                coords.setVisible(true);
            } else {
                coords.setVisible(false);
            }
        });

        viewMenu.add(showMousePosText);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);
    }

    private void createLayout(JComponent... arg) {
        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new main();
            ex.setVisible(true);
        });
    }

}
