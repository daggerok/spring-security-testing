package daggerok.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Client implements Serializable {

  private static final long serialVersionUID = -5252172190065816437L;

  @Id @GeneratedValue(strategy = IDENTITY) Long id;
  @Column(nullable = false) String username;
}
