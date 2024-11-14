package next.workshop.user_micro.infraestructure.db;

import next.workshop.user_micro.domain.User;
import next.workshop.user_micro.infraestructure.api.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<Long, User> db = new HashMap<>();

    static {
        db.put(1L, User.builder().username("jane_doe").biography("Curabitur pretium tincidunt lacus. Nulla gravida orci a odio. Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin.").build());
        db.put(2L, User.builder().username("john_smith").biography("Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed aliquam, urna ut sollicitudin vehicula, justo felis mollis justo, et elementum ipsum magna nec odio.").build());
        db.put(3L, User.builder().username("alice_wonder").biography("In faucibus orci luctus et ultrices posuere cubilia curae. Fusce malesuada, augue nec convallis tincidunt, mauris nisl convallis tortor, id pretium sapien lorem ac lectus.").build());
        db.put(4L, User.builder().username("bob_2024").biography("Integer vitae libero ac risus egestas placerat. Proin ut quam vestibulum, vestibulum dui at, pretium orci. Nunc suscipit eros ligula, ut consectetur ligula gravida ut.").build());
        db.put(5L, User.builder().username("claire_jones").biography("Sed id turpis bibendum, aliquam metus id, varius lorem. Aliquam ac sapien a magna ullamcorper consequat. Ut tristique velit ac orci aliquet, a hendrerit lorem sollicitudin.").build());
        db.put(6L, User.builder().username("mark_2024").biography("Mauris scelerisque arcu eu ligula tincidunt, ac auctor felis feugiat. Donec tincidunt risus non interdum pharetra. Nulla facilisi. Curabitur hendrerit tristique felis, ut dapibus felis viverra ac.").build());
        db.put(7L, User.builder().username("lucas_white").biography("Maecenas malesuada fringilla lectus, vel porttitor eros placerat vitae. Proin aliquam, augue vitae euismod egestas, enim magna gravida velit, et interdum ipsum turpis non nulla.").build());
        db.put(8L, User.builder().username("diana_rose").biography("Nam lacinia risus ut dui gravida, vitae sollicitudin felis bibendum. Etiam ac elit a purus euismod consequat ac sit amet ligula. Nulla volutpat nisi eu justo interdum efficitur.").build());
        db.put(9L, User.builder().username("mike_brown").biography("Nullam in neque id felis pretium suscipit. Curabitur a erat at sem faucibus pharetra. Ut dapibus, nulla ac vehicula fermentum, felis ligula aliquam eros, vitae laoreet ante leo sed ligula.").build());
        db.put(10L, User.builder().username("olivia_green").biography("Ut in quam aliquam, fermentum sem eu, volutpat sapien. Sed placerat vel orci non malesuada. Nulla nec lorem vel ligula scelerisque pretium. In malesuada lectus quis orci porttitor, at hendrerit orci ultricies.").build());
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        if (id == null || id < 0)
            throw new UserNotFoundException("Id not valid" + id);
        if (id > db.size())
            throw new UserNotFoundException("Id doesn't exist");
        try {
            return db.get(id);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(db.values());
    }
}
