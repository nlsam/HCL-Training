package com.hcl.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.springsecurity.models.Euser;
import com.hcl.springsecurity.models.EuserDetails;

import java.util.Optional;

@Service
public class EuserDetailsService implements UserDetailsService{

	@Autowired
    EuserRepository euserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Euser> euser = euserRepository.findByUsername(userName);

        euser.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return euser.map(EuserDetails::new).get();
    }
}
