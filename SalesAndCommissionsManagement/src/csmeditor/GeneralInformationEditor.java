package csmeditor;

public class GeneralInformationEditor {

	private double totalSales = 0;
	private double commission = 0;
	private KindFactory factoryKind;
	private Representative representative;

	public GeneralInformationEditor(Representative selectedRepresentative) {
		this.representative = selectedRepresentative;
		computeSales();
		computeCommission();
	}

	private void computeSales() {
		
		for (Receipt receipt : representative.getReceiptList()) {
			factoryKind = new KindFactory();
			factoryKind.computeKindSales(receipt.getKind(), receipt.getSales());

		}
		computeTotalSales(factoryKind);
	}

	private void computeTotalSales(KindFactory factoryKind) {
		totalSales = factoryKind.getTrousersSales()
				+ factoryKind.getShirtsSales() + factoryKind.getSkirtsSales()
				+ factoryKind.getCoatsSales();
	}

	private void computeCommission() {
		if (totalSales <= 6000) {
			commission = 0;
		} else if (totalSales > 6000 && totalSales <= 10000) {
			commission = (totalSales - 6000) * 0.1;
		} else if (totalSales > 10000 && totalSales < 40000) {
			commission = (10000 * 0.1) + ((totalSales - 10000) * 0.15);
		} else if (totalSales > 40000) {
			commission = (10000 * 0.1) + (30000 * 0.15)
					+ ((totalSales - 30000) * 0.2);
		}
	}
	public double getCommission(){
		return commission;
	}
	public double getTotalSales(){
		return totalSales;
	}

	public double getSkirtsSales() {
		return factoryKind.getSkirtsSales();
	}

	public double getShirtsSales() {
		return factoryKind.getShirtsSales();
	}
	public double getTrousersSales(){
		return factoryKind.getTrousersSales();
	}
	public double getCoatsSales(){
		return factoryKind.getCoatsSales();
	}

}
