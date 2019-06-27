package hacker.hacker.service;

import java.util.List;
import java.util.Optional;

public interface ServiceDetails<T> {
	
	public Optional<List<T>> getServices();

}
