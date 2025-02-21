package com.example.Layout.Management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_layouts", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "layout_id"})
})

@NoArgsConstructor
@AllArgsConstructor
public class UserLayout {
	
	   

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToOne
	    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "layout_id", referencedColumnName = "id")
	    private Layout layout;
	    
	    
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Layout getLayout() {
			return layout;
		}

		public void setLayout(Layout layout) {
			this.layout = layout;
		}

		@Override
		public String toString() {
			return "UserLayout [id=" + id + ", user=" + user + ", layout=" + layout + "]";
		}

		
		

		

		

}
