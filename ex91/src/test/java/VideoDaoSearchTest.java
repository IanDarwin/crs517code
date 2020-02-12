import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import model.VideoRecording;
import util.HibernateUtil;


//
// TODO change the package part of this import to ex91
//
import ex91solution.VideoDaoSearch;


public class VideoDaoSearchTest {

	private static final SessionFactory SESSION_FACTORY = HibernateUtil.getSessionFactory();
	Session session;
	VideoDaoSearch searcher;

	@Before
	public void getSession() {
		session = SESSION_FACTORY.openSession();
		searcher = new VideoDaoSearch();
	}

	@Test(expected=NullPointerException.class)
	public void testSearchAllNull() {
		searcher.findVideos(session, null, null, null);
	}

	@Test
	public void testSearchTitleOnly() {
		List<VideoRecording> ret = searcher.findVideos(session, "Wunderful", null, null);
		assertEquals(1, ret.size());
		assertTrue(ret.get(0).getTitle().startsWith("Wunderful"));
	}

	@Test
	public void testSearchDirectorOnly() {
		List<VideoRecording> ret = searcher.findVideos(session, null, "Sea", null);
		assertEquals(1, ret.size());
		assertTrue(ret.get(0).getTitle().equals("Rollaround Traveller"));
	}

	@Test
	public void testSearchPriceOnly() {
		List<VideoRecording> ret = searcher.findVideos(session, null, null, 12.95);
		assertEquals(1, ret.size());
		assertEquals(9.99d, ret.get(0).getPrice(), 0.01d);
	}

}
