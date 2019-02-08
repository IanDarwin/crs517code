package ex91solution;

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

		if (title == null &&
			director == null &&
			maxPrice == null
			) throw new NullPointerException("Must give at least one search criteria!");
		Criteria crit = session.createCriteria(VideoRecording.class);

		if (title != null) {
			if (title.indexOf('%') == -1)
				title = '%' + title + '%';
			crit.add(Restrictions.like("title", title));
		}

		if (director != null) {
			if (director.indexOf('%') == -1)
				director = '%' + director + '%';
			crit.add(Restrictions.like("director", director));
		}

		if (maxPrice != null) {
			crit.add(Expression.le("price", maxPrice));
		}

		return crit.list();
	}
}
