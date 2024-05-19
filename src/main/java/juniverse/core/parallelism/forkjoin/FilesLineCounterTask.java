package juniverse.core.parallelism.forkjoin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

/**
 * Count number of lines corresponding to each file
 *
 * @author tunm2
 */
public class FilesLineCounterTask extends RecursiveTask<Map<String, Long>> {

    private static final int THRESHOLD = 2;
    
    private List<String> files;
    
    public FilesLineCounterTask(List<String> files) {
        this.files = files;
    }
    
    @Override
    protected Map<String, Long> compute() {
        // base case
        if (files.size() < THRESHOLD) {
            return countLines(files);
        }
        
        // divide to subtasks for processing parallely
        List<RecursiveTask> subTasks = createSubTasks();
        for (RecursiveTask subTask : subTasks) {
            subTask.fork();
        }
        
        // combine results from subtasks
        Map<String, Long> result = new HashMap<>();
        for (RecursiveTask subTask : subTasks) {
            result.putAll((Map<String, Long>)subTask.join());
        }
        
        return result;
    }
    
    /**
     * Divide tasks set to sub tasks
     * 
     * @return 
     */
    private List<RecursiveTask> createSubTasks() {
        List<RecursiveTask> subTasks = new ArrayList<>();
        
        int mid = files.size() / 2;
        RecursiveTask<Map<String, Long>> subTasks1 = new FilesLineCounterTask(files.subList(0, mid));
        RecursiveTask<Map<String, Long>> subTasks2 = new FilesLineCounterTask(files.subList(mid, files.size()));
        
        subTasks.add(subTasks1);
        subTasks.add(subTasks2);
        return subTasks;
    }
    
    private Map<String, Long> countLines(List<String> files) {
        Map<String, Long> lineCountMap = new HashMap<>(files.size());
        for (String file : files)
            lineCountMap.put(file, countLines(file));
        return lineCountMap;
    }
    
    private long countLines(String file) {
        long nlines = 0;
        try (
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
        ) {
            while (buffer.readLine() != null)
                nlines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return nlines;
    }
}
