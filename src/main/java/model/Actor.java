package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue(value="A")
@NamedQuery(name="updateActorLastNameById",
	query="Update Actor a set a.lastName = ?1 where a.lastName = ?2")
public class Actor {
	
	int id;
	Set<VideoRecording> videos = new HashSet<VideoRecording>();
	private String firstName;
	private String lastName;
	
	public Actor() {
		// javabean constructor
	}
	
	public Actor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany
	public Set<VideoRecording> getVideos() {
		return videos;
	}
	public void setVideos(Set<VideoRecording> films) {
		this.videos = films;
	}
	
	/** Make relationship bidirectional */
	public void addVideo(VideoRecording v) {
		this.getVideos().add(v);
		v.getActors().add(this);
	}
}
