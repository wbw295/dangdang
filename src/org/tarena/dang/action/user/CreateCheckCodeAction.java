package org.tarena.dang.action.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.tarena.dang.action.BaseAction;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CreateCheckCodeAction extends BaseAction {
	private InputStream input;
	private static int WIDTH = 200;
	private static int HEIGHT = 80;
	private static int NUM = 4;
	// 验证码字符
	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z' };

	public String execute() {
		byte[] image = randomImage();
		input = new ByteArrayInputStream(image);
		return "success";
	}

	private byte[] randomImage() {
		Random r = new Random();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.setColor(randomColor(r));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0, 0, 0));
		StringBuffer number = new StringBuffer();
		for (int i = 0; i < NUM; i++) {
			// 设置画笔随机颜色
			g.setColor(randomColor(r));
			// 设置验证码字符随机高度
			int h = (int) (HEIGHT * 6 / 10 * r.nextDouble() + HEIGHT * 4/ 10);
			// 设置随机字体
			g.setFont(new Font(null, Font.BOLD | Font.ITALIC, h));
			// 设置随机字符
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			// 保存取到的验证码
			number.append(ch);
			// 画验证码
			g.drawString(ch, i * WIDTH * 9 / 10 / NUM, h);

		}
		//把验证码信息绑定到session上；
		session.put("check_code", number);
		// 绘制干扰线
		for (int i = 0; i <= 12; i++) {
			g.setColor(randomColor(r));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r
					.nextInt(HEIGHT));

		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		try {
			encoder.encode(image);
			return os.toByteArray();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

}
