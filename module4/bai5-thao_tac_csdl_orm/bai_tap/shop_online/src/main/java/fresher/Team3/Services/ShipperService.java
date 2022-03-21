package fresher.Team3.Services;

import java.util.List;
import java.util.Optional;

import fresher.Team3.Enities.ShipperEnity;

public interface ShipperService {
	List<ShipperEnity> getAllShipper();

	void saveShiper(ShipperEnity shiper);

	void deleteShiper(Integer id);

	Optional<ShipperEnity> findShiperById(Integer id);
}
