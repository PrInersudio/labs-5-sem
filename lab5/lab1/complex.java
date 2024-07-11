/**
	Лабораторная работа №1
	Семин Владислав
	ККСО-01-20
*/
package lab1;
public class complex implements Comparable<complex>
{
	/** вещественная часть */
	public double Re;
	/** мнимая часть */
	public double Im;
	/** конструктор без параметров */
	public complex ()
	{
		Re = 0;
		Im = 0;
	}
	/** конструктор с параметрами */
	public complex (double RePar, double ImPar)
	{
		Re = RePar;
		Im = ImPar;
	}
	/** получает из модуля и аргумента комплексное число в алгебраической форме */
	public complex AlgComplex (double num_abs, double num_arg)
	{
		double num_Re = Math.cos(num_arg) * num_abs;
		double num_Im = Math.sin(num_arg) * num_abs;
		return new complex (num_Re, num_Im);
	}
	/** модуль */
	public double abs ()
	{
		return Math.sqrt(Math.pow(Re, 2) + Math.pow(Im, 2));
	}
	/** главный аргумент */
	public double arg ()
	{
		if ((Re == 0.0D)&&(Im == 0.0D))
			return Double.NaN;
		if (Im == 0.0D)
			return Re > 0 ? 0 : Math.PI;
		if (Re == 0.0D)
			return Im > 0 ? Math.PI/2 : -Math.PI/2;
		if (Re > 0.0D)
			return Math.atan(Im/Re);
		if (Im > 0.0D)
			return Math.PI + Math.atan(Im/Re);
		return Math.atan(Im/Re) - Math.PI;
	}
	/** вещественная степень */
	public complex pow (double exponent)
	{
		if ((Re == 0.0D)&&(Im == 0.0D))
			return new complex();
		double new_abs = Math.pow(abs(), exponent);
		double new_arg = arg() * exponent;
		return AlgComplex(new_abs, new_arg);
	}
	/** комплексная сумма */
	public complex sum (complex addnum)
	{
		return new complex (Re + addnum.Re, Im + addnum.Im);
	}
	/** комплексная разность */
	public complex dif (complex subnum)
	{
		return new complex (Re - subnum.Re, Im - subnum.Im);
	}
	/** умножение комплексных чисел */
	public complex mul (complex factor)
	{
		if ((Re == 0.0D)&&(Im == 0.0D)||(factor.Re == 0.0D)&&(factor.Im == 0.0D))
			return new complex();
		return AlgComplex(abs() * factor.abs(), arg() + factor.arg());
	}
	/** деление комплексных чисел */
	public complex div (complex divider)
	{
		return AlgComplex(abs()/divider.abs(), arg() - divider.arg());
	}
	/** сравнивает комплексные чилсла по модулю */
	public int compareTo(complex comparable) {
		if (this.abs() > comparable.abs())
			return 1;
		if (this.abs() < comparable.abs())
			return -1;
		return 0;
	}
	/** вывод комплексного числа в виде Re + i*Im */
	public String toString() {
		return Re + " + " + "i" + Im;
	}
}