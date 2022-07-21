package noteapp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// 这个一个测试类，负责放thread main方法
public class ultimate {

	// 主函数入口
	public static void main(String[] args) {

		// 实例化这个NoteInitializing类
		NoteInitializing note = new NoteInitializing();

		// 调用实例化类的方法 -->体现其封装性
		note.showNote();
	}
}

// 类的实体
class NoteInitializing {

	/**
	 * 
	 * @Description showNote()这个方法实现，进行封装
	 * @author lhtspace
	 * @date 2022年5月26日上午11:51:14
	 */
	public void showNote() {

		// 建立一个窗口，窗口的标题为记事本
		final JFrame jFrame = new JFrame("记事本");

		// 创建一个字体对象
		// 设置缺省（default）字体的类型，大小和颜色
		// BOLD是表示粗体的意思
		Font font = new Font("", Font.BOLD, 30);

		// 建立菜单条用来存放菜单
		JMenuBar bar = new JMenuBar();

		// 将菜单条添加到窗口中,并将其设置在窗口的上面（北面）
		jFrame.add(bar, BorderLayout.NORTH);

		// 建立三个菜单
		JMenu fileMenu = new JMenu("文件");
		JMenu editMenu = new JMenu("编辑");
		JMenu formatMenu = new JMenu("格式");

		// 将菜单添加到菜单条中
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(formatMenu);

		// 建立文件菜单的菜单项：打开和保存
		JMenuItem openMenu = new JMenuItem("打开");
		JMenuItem saveMenu = new JMenuItem("保存");

		// 将菜单项添加到文件菜单的条中
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);

		// 建立多个编辑的菜单项
		JMenuItem copyMenu = new JMenuItem("复制");
		JMenuItem pasteMenu = new JMenuItem("粘贴");
		JMenuItem cutMenu = new JMenuItem("剪切");
		JMenuItem DeleteMenu = new JMenuItem("删除");
		JMenuItem SelectAllMenu = new JMenuItem("全选");

		// 将菜单项添加到编辑菜单条中
		editMenu.add(copyMenu);
		editMenu.add(pasteMenu);
		editMenu.add(cutMenu);
		editMenu.add(DeleteMenu);
		editMenu.add(SelectAllMenu);

		// 建立多个格式的菜单项
		JMenu sizeFont = new JMenu("字体大小");
		JMenu typeFont = new JMenu("字体类型");
		JMenu colorFont = new JMenu("字体颜色");

		// 将多个菜单条添加到格式菜单条中
		formatMenu.add(sizeFont);
		formatMenu.add(typeFont);
		formatMenu.add(colorFont);

		// 设置字体大小的类型并加入到字体大小菜单条中
		JMenuItem minSize = new JMenuItem("30");
		JMenuItem middleSize = new JMenuItem("50");
		JMenuItem maxSize = new JMenuItem("80");

		sizeFont.add(minSize);
		sizeFont.add(middleSize);
		sizeFont.add(maxSize);

		// 设置字体类型的类型并加入到字体类型菜单条中
		JMenuItem type1 = new JMenuItem("楷体");
		JMenuItem type2 = new JMenuItem("黑体");
		JMenuItem type3 = new JMenuItem("宋体");

		typeFont.add(type1);
		typeFont.add(type2);
		typeFont.add(type3);

		// 设置字体颜色的类型并加入到字体颜色菜单条中
		JMenuItem blue = new JMenuItem("蓝色");
		JMenuItem black = new JMenuItem("黑色");
		JMenuItem green = new JMenuItem("绿色");

		colorFont.add(blue);
		colorFont.add(black);
		colorFont.add(green);

		// 创建文本域
		final JTextArea jTextArea = new JTextArea();

		// 创建记事本滚动条,并运用到JTextArea上
		JScrollPane jScrollPane = new JScrollPane(jTextArea);

		// 将设置好的字体的（default）相关内容加入到jTextArea中
		jTextArea.setFont(font);
		
		//将滚动条添加到jFrame中
		jFrame.add(jScrollPane);
		
		//设置选中文字的字体颜色
		jTextArea.setSelectedTextColor(Color.BLUE);

		// 光标的颜色设置为红色
		jTextArea.setCaretColor(Color.RED);

		// 使用static （不用实例化，直接调用方法）显示窗口在电脑屏幕的中间
		initFrame(jFrame, 1200, 800);

		//设置的提示功能在jFrame这个窗口前弹出，并且在不处理此提示窗口的情况下，不能操作jFrame窗口
		
		// 设置使用提示功能1
		JOptionPane.showMessageDialog(jFrame, "欢迎使用记事本测试版", "通知", JOptionPane.INFORMATION_MESSAGE);

		// 设置使用提示功能2
		JOptionPane.showMessageDialog(jFrame, "制作不易，希望三连支持一下！", "警告", JOptionPane.WARNING_MESSAGE);

		// 设置使用提示功能3,误点关闭操作的人性化设置
		// 创建一个窗口监听，当点击关闭的时候执行以下操作，并且使用匿名类创建的对象
		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(jFrame, "请检查一下，文件是否保存", "通知", JOptionPane.INFORMATION_MESSAGE);
				int num = JOptionPane.showConfirmDialog(jFrame, "你确认退出吗");
				/*
				 *  JOptionPane.showConfirmDialog(jFrame, "你确认退出吗"); 会返回三个值
				 * 	是：0
				 *  否：1
				 * 	取消：2
				 * */
				//使用if来进行判断
				if (num == 0) {
					jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					// 如果返回 1或者2时，对窗口不做任何关闭处理，返回主界面
					JOptionPane.showMessageDialog(jFrame, "怎么啦，不舍得我吗？", "通知", JOptionPane.INFORMATION_MESSAGE);
					jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		// 添加字体大小设置监听
		minSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//设置字体的大小，其他的不设置
				Font font = new Font("", Font.BOLD, 30);
				jTextArea.setFont(font);
			}
		});

		middleSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("", Font.BOLD, 50);
				jTextArea.setFont(font);
			}
		});

		maxSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("", Font.BOLD, 80);
				jTextArea.setFont(font);
			}
		});

		// 添加字体类型设置监听
		type1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//设置字体的类型，其他的不设置
				Font font = new Font("楷体", Font.BOLD, 30);
				jTextArea.setFont(font);
			}
		});

		type2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("黑体", Font.BOLD, 30);
				jTextArea.setFont(font);

			}
		});

		type3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("宋体", Font.BOLD, 30);
				jTextArea.setFont(font);
			}
		});

		// 添加字体颜色设置监听
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//设置字体的颜色，其他的不设置
				jTextArea.setForeground(Color.BLUE);
			}
		});

		black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea.setForeground(Color.BLACK);
			}
		});

		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea.setForeground(Color.GREEN);
			}
		});

		// 添加一个菜单项按钮监听
		openMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 创建一个可以打开文件的窗口，并且显示在jFrame里跳出
				FileDialog fileDialog = new FileDialog(jFrame, "请选择打开路径", FileDialog.LOAD);
				// 此窗口设置为可视化
				fileDialog.setVisible(true);

				// 处理异常，目前发现自能用try和catch 目前自我尝试还不能使用throws
				try {
					//得到文件的位置和名称
					FileReader fileReader = new FileReader(fileDialog.getDirectory() + fileDialog.getFile());
					// 设置字符数组对象，来存储文件内容
					char[] chars = new char[100];
					//存储文件内容,并设置计数器，统计字符的个数
					int len = fileReader.read(chars);

					// 创建一个String 的对象output来输出
					//初始化的时候不要将output设置为null，否则打开的文件中开头都会有null
					String output ="";
					while (len != -1) {
						output += new String(chars, 0, len);
						len = fileReader.read(chars);
					}

					// 输出内容
					jTextArea.setText(output);
					fileReader.close();
				} catch (Exception e1) {
					System.out.println("file cannot be found!!!");
				}
			}
		});

		// 实现复制的功能
		copyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(jTextArea.getSelectedText());
				clipboard.setContents(stringSelection, null);
			}
		});
		// 实现粘贴的功能
		pasteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					Transferable transferable = clipboard.getContents(this);
					jTextArea.append((String) transferable.getTransferData(DataFlavor.stringFlavor));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (UnsupportedFlavorException e1) {
					e1.printStackTrace();
				}
			}
		});

		// 实现删除的功能
		DeleteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea.requestFocus();
				jTextArea.replaceRange("", jTextArea.getSelectionStart(), jTextArea.getSelectionEnd());
			}
		});

		// 全选
		SelectAllMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea.selectAll();
			}
		});

		// 创建一个监听用来保存文件
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog(jFrame, "请选择保存路径", FileDialog.SAVE);
				fileDialog.setVisible(true);
				try {
					FileWriter fileWriter = new FileWriter(fileDialog.getDirectory() + fileDialog.getFile());
					fileWriter.write(jTextArea.getText());
					fileWriter.close();
				} catch (Exception e1) {
					System.out.println("file cannot be found!!!");
				}
			}
		});

		// 创建一个剪切监听
		cutMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection editText = new StringSelection(jTextArea.getSelectedText());
				clipboard.setContents(editText, null);
				int start = jTextArea.getSelectionStart();
				int end = jTextArea.getSelectionEnd();

				// 将开头到结尾的内容用""来代替（replace）
				jTextArea.replaceRange("", start, end);
			}
		});

	}
	
	// 设置窗口显示在电脑的正中间，自动获取电脑的宽度，和高度
	public static void initFrame(JFrame jframe, int width, int height) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();// Dimension 尺寸
		int x = (int) d.getWidth();
		int y = (int) d.getHeight();
		jframe.setBounds((x - width) / 2, (y - height) / 2, width, height);
		jframe.setVisible(true);

	}

}
