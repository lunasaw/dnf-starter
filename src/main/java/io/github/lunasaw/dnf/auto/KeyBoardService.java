package io.github.lunasaw.dnf.auto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author luna
 * @date 2024/6/21
 */
public class KeyBoardService {

    public static class HotkeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_F1) {
                System.out.println("F1 key pressed");
            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.addKeyListener(new HotkeyListener());
            frame.setSize(200, 200);
            frame.setVisible(true);
        }
    }

    public static class GlobalKeyListenerExample {
        public static void main(String[] args) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(KeyEvent e) {
                    System.out.println(e.getKeyCode());
                    if (e.getID() == KeyEvent.KEY_PRESSED && e.isAltDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_T) {
                        System.out.println("Alt+Shift+T pressed");
                        return true; // consume the event to prevent other applications from receiving it
                    }
                    return false;
                }
            });

            while (true) {

            }
        }
    }

    public static class test extends JFrame implements KeyListener {
        public test() {
            //设置界面大小
            this.setSize(603, 680);

            //设置标题
            this.setTitle("拼图小游戏 V1.0");

            //设置永远置顶
            this.setAlwaysOnTop(true);

            //设置程序随着窗口关闭而结束运行
            //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setDefaultCloseOperation(3);

            //设置界面居中
            this.setLocationRelativeTo(null);

            //取消默认放置位置
            this.setLayout(null);

            //绑定键盘监听事件
            this.addKeyListener(this);

            //设置界面可视化
            this.setVisible(true);

        }


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按住不松开");
            char c = e.getKeyChar();
            int code = e.getKeyCode();
            System.out.println(c);
            System.out.println(code);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("松开");
        }

        public static void main(String[] args) {
            new test();
        }
    }
}
