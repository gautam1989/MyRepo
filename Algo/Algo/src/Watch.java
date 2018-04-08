import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Watch {
public static void main(String[] args) {
	
	Path path = Paths.get("/Users/gautamverma/Desktop/watchtest/");
	//System.out.println(dir);
    
	FileSystem fs = path.getFileSystem();

    // We create the new WatchService using the new try() block
    try (WatchService service = fs.newWatchService()) {

        // We register the path to the service
        // We watch for creation events
    	path.register(service, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

        // Start the infinite polling loop
        WatchKey key = null;
        while (true) {
            key = service.take();

            // Dequeueing events
            Kind<?> kind = null;
            for (WatchEvent<?> watchEvent : key.pollEvents()) {
                // Get the type of the event
                kind = watchEvent.kind();
                if (OVERFLOW == kind) {
                    continue; // loop
                } else if (ENTRY_CREATE == kind) {
                    // A new Path was created
                    Path newPath = ((WatchEvent<Path>) watchEvent)
                            .context();
                    // Output
                    System.out.println("New path created: " + newPath);
                } else if (ENTRY_MODIFY == kind) {
                    // modified
                    Path newPath = ((WatchEvent<Path>) watchEvent)
                            .context();
                    // Output
                    System.out.println("New path modified: " + newPath);
                }
            }

            if (!key.reset()) {
                break; // loop
            }
        }

    } catch (IOException ioe) {
        ioe.printStackTrace();
    } catch (InterruptedException ie) {
        ie.printStackTrace();
    }		
}
	
	
}
