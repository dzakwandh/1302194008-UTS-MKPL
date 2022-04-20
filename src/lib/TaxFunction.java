package lib;

public class TaxFunction {

	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
	 * dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan
	 * bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan)
	 * dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena
	 * pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah
	 * sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya
	 * ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
			boolean isMarried, int numberOfChildren) {

		int tax = 0;

		return checkingTax(tax);
	}

	public static void checkNumMonthWork(int numberOfMonthWorking) {
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	}

	public static void checkChildren(int numberOfChildren) {
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
	}

	public static int checkingTax(int tax) {
		if (tax < 0) {
			return 0;
		} else {
			return tax;
		}
	}

	public static int taxIfisMarried(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
			int deductible, int numberOfChildren) {
		return (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible
				- (54000000 + 4500000 + (numberOfChildren * 1500000))));
	}

	public static int taxIfisNotMarried(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
			int deductible) {
		return (int) Math.round(
				0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));
	}
}
