package fileparsing;

import java.io.IOException;

public interface IOFile<T> {
	
	T[] readFromFile(String fileName) throws IOException;
	void writeToFile(String fileName) throws IOException;
	void print();
}
