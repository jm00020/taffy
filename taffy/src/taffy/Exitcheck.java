package taffy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Exitcheck extends JDialog {

	private final JPanel contentPanel2 = new JPanel();

	public Exitcheck() { //시물레이션 실행 도중 종료할 시 확인 받음
		setModal(true);
		setBounds(170, 170, 306, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel2, BorderLayout.CENTER);
		contentPanel2.setLayout(null);
		{
			JLabel label = new JLabel("\uC2DC\uBBAC\uB808\uC774\uC158\uC744 \uC885\uB8CC\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
			label.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(34, 20, 221, 15);
			contentPanel2.add(label);
		}
		{
			JLabel label = new JLabel("(\uC2E4\uD589 \uC911\uC77C \uACBD\uC6B0 \uB370\uC774\uD130\uB97C \uC5BB\uC744 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.)");
			label.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(0, 45, 288, 15);
			contentPanel2.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						Gui.exitcheck = true;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						Gui.exitcheck = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
