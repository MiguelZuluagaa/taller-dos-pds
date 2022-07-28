package co.com.poli.userservice.service;

import co.com.poli.userservice.clientFeign.BookingClient;
import co.com.poli.userservice.model.Booking;
import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BookingClient bookingClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(User user) {

        ModelMapper modelMapper = new ModelMapper();

        Object bookingsResponse = bookingClient.findAll().getData();
        ArrayList<Object> bookingsMaps = (ArrayList<Object>) bookingsResponse;
        List<Booking> bookings = bookingsMaps.stream().map(booking -> modelMapper.map(booking, Booking.class)).collect(Collectors.toList());

        Optional<Booking> findBookings = bookings.stream().filter(booking -> booking.getUserId()==user.getId() ).findFirst();

        if(!findBookings.isPresent()){
            userRepository.delete(user);
            return true;
        }
        return false;



    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
