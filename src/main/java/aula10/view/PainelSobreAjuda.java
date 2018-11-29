package aula10.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

public class PainelSobreAjuda extends JPanel {
	public PainelSobreAjuda() {
		
		JTextPane txtpnLoremIpsumDolor = new JTextPane();
		txtpnLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In dapibus ipsum at porta imperdiet. In erat ex, vulputate ut nibh id, faucibus elementum odio. Morbi pharetra blandit purus, in dictum magna tristique id. Donec pellentesque risus a mauris euismod ullamcorper. Sed pretium nulla sed diam accumsan, in commodo urna dignissim. Quisque a urna at augue convallis mollis at non nunc. Proin metus metus, placerat vel ligula ac, congue ornare ipsum. Aenean gravida justo et faucibus pulvinar. Suspendisse quis congue sem. Duis a blandit neque. Ut eu venenatis nulla, ut porta mauris. Praesent eget libero purus. In efficitur lectus elit, nec lacinia justo condimentum vel. Nunc feugiat scelerisque augue. In condimentum lacus et magna auctor commodo.\r\n\r\nPraesent ut accumsan erat. Aenean porta, lorem varius tempus viverra, risus enim pharetra tellus, sit amet porttitor enim arcu maximus ligula. Aliquam vitae ipsum eros. Pellentesque commodo dui id vehicula eleifend. Sed at sapien eros. Duis sit amet sapien blandit, ullamcorper tellus quis, accumsan sapien. Sed et condimentum mauris. Etiam condimentum consectetur tortor, ac convallis libero feugiat id. Donec ultrices malesuada iaculis. Integer rhoncus dui nec nunc sollicitudin volutpat. Donec interdum nunc nec neque volutpat sagittis sagittis ut sapien. Aliquam tincidunt euismod eros at malesuada. Praesent at ornare magna.\r\n\r\nFusce laoreet mollis purus sed faucibus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam at ultrices ex. Sed sit amet orci sed eros ultricies ultrices. Nunc diam metus, tincidunt sed arcu et, aliquam interdum mi. Aliquam id consequat diam. Aliquam erat volutpat. Morbi mi elit, rhoncus non blandit non, tristique eget urna. Donec sodales vulputate urna in ultricies. Proin turpis augue, aliquam gravida purus vel, tristique mattis urna. Ut pharetra, ligula vitae facilisis rutrum, urna lectus lobortis purus, vitae finibus nibh neque vel quam. Cras egestas, lectus eu egestas auctor, est turpis finibus erat, quis malesuada erat est sed massa. Sed iaculis et ex in suscipit. Sed sollicitudin ante vel dictum laoreet. Donec suscipit velit eu sapien molestie consectetur.\r\n\r\nUt ipsum diam, mattis et porta sit amet, ullamcorper id quam. Nam mi lorem, volutpat vitae magna sed, bibendum vulputate elit. Fusce a pulvinar libero. Curabitur dignissim sed neque dignissim lobortis. Quisque elementum odio vel orci consequat vehicula. Phasellus in tincidunt metus. Etiam magna lacus, ultricies at egestas non, efficitur at libero. Sed non lacus elementum, rutrum ante a, mattis nunc. Cras lectus elit, vulputate non ligula eget, pulvinar blandit mi. Praesent sed eros non ipsum efficitur tincidunt. Vivamus ac metus eu mauris rutrum ornare a eu orci. Aenean scelerisque vitae nisl id viverra.\r\n\r\nAliquam vitae velit eget magna vestibulum lacinia vel a ligula. Etiam tempus, neque nec cursus egestas, lorem est tincidunt tortor, sit amet tristique est arcu a felis. Sed non orci sem. In hac habitasse platea dictumst. Pellentesque scelerisque condimentum augue id vehicula. Ut aliquam, libero non placerat placerat, mauris sem feugiat lorem, id tincidunt justo erat id nisi. Duis condimentum quam ligula, nec bibendum massa facilisis nec. Mauris sit amet purus rutrum mauris vehicula tristique ut sed eros. Aenean aliquet mi et rhoncus auctor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnLoremIpsumDolor, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnLoremIpsumDolor, GroupLayout.PREFERRED_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
