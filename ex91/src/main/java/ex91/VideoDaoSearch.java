package ex91;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import model.VideoRecording;

public class VideoDaoSearch {

	/**
	 * Implements a search function for Videos.
	 * String parameters that do not include % will be surrounded by %
	 * @parameter title A title substring; may include %, may be null.
	 * @parameter director A director's name substring; may include %, may be null.
	 * @parameter maxPrice A maximum price; may be null.
	 * @throws NullPointerException if all the criteria are null.
	 */
	public List<VideoRecording> findVideos(Session session,
		String title, String director, Double maxPrice) {

		// TODO if all fields are null, throw a NPE

		// TODO create a Criteria

		// TODO add title into criteria as restriction if not null; surround with "%"
		// if no "%" present in it.

		// TODO add director - same as above

		// TODO add price: use Expression.le(field, maximum)

		// TODO
		// return crit.list();
		return null;
	}
}
