package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee extends Person {

	private String employeeId;
	private String idNumber;
	private Person dataPerson;

	private LocalDate dateJoined;
	private int monthWorkingInYear;

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;

	public Employee(String employeeId, String idNumber, LocalDate dateJoineDate, Person dataPerson) {
		this.employeeId = employeeId;
		this.idNumber = idNumber;
		this.dateJoined = dateJoined;
		this.dataPerson = dataPerson;

		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();

		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	public void setMonthlySalary(int grade) {
		if (grade == 1) { // Grade 1: 3.000.000 per bulan.
			monthlySalary = 3000000;
			if (dataPerson.getIsForeigner()) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		} else if (grade == 2) { // Grade 2: 5.000.000 per bulan
			monthlySalary = 5000000;
			if (dataPerson.getIsForeigner()) {
				monthlySalary = (int) (5000000 * 1.5);
			}
		} else if (grade == 3) { // Grade 3: 7.000.000 per bulan
			monthlySalary = 7000000;
			if (dataPerson.getIsForeigner()) {
				monthlySalary = (int) (7000000 * 1.5);
			}
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}

	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}

	public int getAnnualIncomeTax() {

		/*
		 * Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		 * bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		 */
		LocalDate date = LocalDate.now();
		if (date.getYear() == dateJoined.getDayOfYear()) {
			monthWorkingInYear = date.getMonthValue() - dateJoined.getDayOfMonth();
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
