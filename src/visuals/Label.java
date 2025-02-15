package src.visuals;

import javax.swing.JLabel;
import java.awt.*;
import java.io.*;

public class Label extends JLabel {
  protected Font ArcadeFont;

  public Label(String text, int fontSize, Color c, int x, int y, int w, int h) {
    super(text);
    this.setForeground(c);
    this.setBounds(x, y, w, h);

    try {
      ArcadeFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/Arcade.ttf"));
      ArcadeFont = ArcadeFont.deriveFont(Font.BOLD, fontSize);
      this.setFont(ArcadeFont);
    } catch (FontFormatException | IOException e) {
      System.err.print("Error when trying to open font file: " + e);
    }
  }
}
