package HW3;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;

public class Main extends Composite {
	private Text item;
	private Text cost;
	private Text quan;
	private Text slip;
	private Text TotalCost;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		Main List = new Main(shell, SWT.NONE);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}

	public Main(Composite parent, int style) {
		super(parent, style);
		setLayout(null);

		Label lblSalesList = new Label(this, SWT.NONE);
		lblSalesList.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		lblSalesList.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblSalesList.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.BOLD));
		lblSalesList.setAlignment(SWT.CENTER);
		lblSalesList.setBounds(0, 0, 450, 35);
		lblSalesList.setText("Sales List");

		Label lblItemName = new Label(this, SWT.NONE);
		lblItemName.setBounds(10, 41, 67, 16);
		lblItemName.setText("Item Name:");

		Label lblItemCost = new Label(this, SWT.NONE);
		lblItemCost.setBounds(10, 70, 56, 16);
		lblItemCost.setText("Item Cost:");

		Label lblItemQuantity = new Label(this, SWT.NONE);
		lblItemQuantity.setBounds(10, 103, 82, 16);
		lblItemQuantity.setText("Item Quantity:");

		item = new Text(this, SWT.BORDER);
		item.setBounds(98, 38, 304, 19);

		cost = new Text(this, SWT.BORDER);
		cost.setBounds(98, 67, 304, 19);

		quan = new Text(this, SWT.BORDER);
		quan.setBounds(98, 100, 304, 19);

		slip = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		slip.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		slip.setBounds(10, 167, 430, 86);

		Button btnEnter = new Button(this, SWT.NONE);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				SaleSlip.addToList(item.getText(), cost.getText(), quan.getText());
				ArrayList<String> Slip = new ArrayList<String>(SaleSlip.getList());
				String prList = "";
				if (SaleSlip.isValid() == false) {
					slip.setText("Invalid Input. Please try again");
				} else {
					int count = 0;
					for (String str : Slip) {
						prList += str + "\t";
						count++;
						if (count == 3) {
							prList += "\n";
							count = 0;
						}
						slip.setText(prList);
						TotalCost.setText("$ " +String.valueOf(SaleSlip.getTotal()));
					}
				}
			}
		});
		btnEnter.setBounds(182, 136, 70, 21);
		btnEnter.setText("Enter");

		Label lblTotalCost = new Label(this, SWT.NONE);
		lblTotalCost.setBounds(70, 274, 56, 16);
		lblTotalCost.setText("Total Cost:");

		TotalCost = new Text(this, SWT.BORDER);
		TotalCost.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		TotalCost.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		TotalCost.setEditable(false);
		TotalCost.setBounds(133, 271, 82, 19);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
