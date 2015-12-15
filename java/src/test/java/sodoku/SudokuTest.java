package sodoku;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import com.water.sodoku.SudokuSolver;

public class SudokuTest {
	// @Rule
	// public SudokuRule rule = new SudokuRule();
	SudokuSolver sudokuSolver;

	@Before
	public void setup() throws Exception {
		sudokuSolver = (SudokuSolver) Class.forName("sodoku.impl.yl70801.SudokuSolverImpl")
				.newInstance();
	}

	// 1.2
	@Test
	public void sodoku01() {
		assertArrayEquals(
				"438561792219347658567892134651234879972618543384975261725483916893156427146729385".getBytes(),
				sudokuSolver.solve(".38...79.2...4.6.856...2..4..1.3.....7.6.8.4.....7.2..7..4...168.3.5...7.46...38."
						.getBytes()));
	}

	// 1.2
	@Test
	public void sodoku02() {
		assertArrayEquals(
				"527169834891734256346582791473615982968243175152897463619328547734951628285476319".getBytes(),
				sudokuSolver.solve("..71.98............46.8.79.4..6.5..2.6..4..7.1..8.7..3.19.2.54............54.63.."
						.getBytes()));
	}

	// 1.5
	@Test
	public void sodoku03() {
		assertArrayEquals(
				"824653791759124683316789245597846132162937854483215967275398416638471529941562378".getBytes(),
				sudokuSolver.solve(".2..5..9.7....4..3.....92......4613.1..9.7..4.8321......53.....6..4....9.4..6..7."
						.getBytes()));
	}

	// 2.0
	@Test
	public void sodoku04() {
		assertArrayEquals(
				"135286479246973158789145623327851964961724385458369217673418592592637841814592736".getBytes(),
				sudokuSolver.solve(".3..8.4.....9.3..87.91..6...2....96.9...2...5.58....1...3..85.25..6.7.....4.9..3."
						.getBytes()));
	}

	// 3.0
	@Test
	public void sodoku05() {
		assertArrayEquals(
				"923645817145378926678291534562189743834752169719463258281936475397514682456827391".getBytes(),
				sudokuSolver.solve("9.36.58..........6.7.29...456.1...................3.582...36.7.3..........68.73.1"
						.getBytes()));
	}

	// 3.2
	@Test
	public void sodoku06() {
		assertArrayEquals(
				"486912375512783469379465218234576981758194623691238547965827134843651792127349856".getBytes(),
				sudokuSolver.solve("4.....3.5.1.....6....4.52.8..4.769.....194.....123.5..9.58.7....4.....9.1.7.....6"
						.getBytes()));
	}

	// 4.2
	@Test
	public void sodoku07() {
		assertArrayEquals(
				"251693478697824153348715692785231946412956387963478215526189734134567829879342561".getBytes(),
				sudokuSolver.solve("2...9...8.9.....5...87.56....52.19..4.......7..34.82....61.97...3.....2.8...4...1"
						.getBytes()));
	}

	// 4.4
	@Test
	public void sodoku08() {
		assertArrayEquals(
				"497568123362149578518237469153672984679384215284951637736415892825796341941823756".getBytes(),
				sudokuSolver.solve("..7.....3....4.5...1.2..46.1..67..8...9...2...8..51..7.36..5.9...5.9....9.....7.."
						.getBytes()));
	}

	// 5.0
	@Test
	public void sodoku09() {
		assertArrayEquals(
				"829351467473869152615274893341582679962743581587916234256497318194638725738125946".getBytes(),
				sudokuSolver.solve(".2..51..747.86.......2..8...4....6.99.......15.7....3...6..7.......38.257..12..4."
						.getBytes()));
	}

	// 5.6
	@Test
	public void sodoku10() {
		assertArrayEquals(
				"354981267189267345672345891293756418541892736768134952436528179815479623927613584".getBytes(),
				sudokuSolver.solve("..49.1....8...734..7..4...129......8..1...7..7......524...2..7..154...2....6.35.."
						.getBytes()));
	}

	// 6.6
	@Test
	public void sodoku11() {
		assertArrayEquals(
				"941682357537491826268735491895216743672349185314578962786923514123854679459167238".getBytes(),
				sudokuSolver.solve("9.16..3.7....9.8..2....5.918..2..7...7.....8...4..8..278.9....4..3.5....4.9..72.8"
						.getBytes()));
	}

	// 7.1
	@Test
	public void sodoku12() {
		assertArrayEquals(
				"586491723149327856732568914298653147467182395315749268824975631671234589953816472".getBytes(),
				sudokuSolver.solve(".....172.14.3...5.7.2...9..2...5..4....1.2....1..4...8..4...6.1.7...4.89.538....."
						.getBytes()));
	}

	// 7.2
	@Test
	public void sodoku13() {
		assertArrayEquals(
				"571632489234897165689415273718923654325146798496758312147289536852361947963574821".getBytes(),
				sudokuSolver.solve(".7.6.2.8...48.71......1....7.8...6.4.2.....9.4.6...3.2....8......23.19...6.5.4.2."
						.getBytes()));
	}

	// 7.6
	@Test
	public void sodoku14() {
		assertArrayEquals(
				"782139546913645782456782391839257164271364859564891237397516428628473915145928673".getBytes(),
				sudokuSolver.solve("...1........64.78..56....9.8.92...6...........6...12.7.9....42..28.73........8..."
						.getBytes()));
	}

	// 8.2
	@Test
	public void sodoku15() {
		assertArrayEquals(
				"675891234389247156142356789413725698826419375957683412534972861798164523261538947".getBytes(),
				sudokuSolver.solve(".7...1..4..9.47..6......78.4.37....8.2.....7.9....34.2.34......7..16.5..2..5...4."
						.getBytes()));
	}

	// 10.7
	@Test
	public void sodoku16() {
		assertArrayEquals(
				"812753649943682175675491283154237896369845721287169534521974368438526917796318452".getBytes(),
				sudokuSolver.solve("8..........36......7..9.2...5...7.......457.....1...3...1....68..85...1..9....4.."
						.getBytes()));
	}
}
