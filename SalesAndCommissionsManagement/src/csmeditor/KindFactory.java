package csmeditor;


public class KindFactory {
	
	
	private double trousersSales = 0;
	private double skirtsSales = 0;
	private double shirtsSales = 0;
	private double coatsSales = 0;
	
	
	public void computeKindSales(String kind,double sales) {
		switch (kind) {			
		case KindType.TROUSERS:
			computeTrousersSales(sales);
			break;
		case KindType.SKIRTS:
			computeSkirtSales(sales);
			break;
		case KindType.COATS:
			computeCoatsSales(sales);
			break;
		case KindType.SHIRTS:
			computeShirtSales(sales);
			break;
		}
	}

	private void computeTrousersSales(double sales) {
		trousersSales += sales;
	}

	private void computeSkirtSales(double sales) {
		skirtsSales += sales;
	}

	private void computeShirtSales(double sales) {
		shirtsSales += sales;
	}

	private void computeCoatsSales(double sales) {
		coatsSales += sales;
	}

	public double getSkirtsSales() {
		return skirtsSales;
	}

	public double getShirtsSales() {
		return shirtsSales;
	}
	public double getTrousersSales(){
		return trousersSales;
	}
	public double getCoatsSales(){
		return coatsSales;
	}
}
