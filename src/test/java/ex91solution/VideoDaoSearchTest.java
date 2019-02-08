package ex91solution;

import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;

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

}
