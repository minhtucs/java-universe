package juniverse.core.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tunm2
 */
public class GroupingBy {

    public static void main(String[] args) {
        List<Tag> tags = Arrays.asList(new Tag(3, "Under 18", 3), new Tag(1, "Male", 1), new Tag(2, "Ho Chi Minh", 2));
        
    }
    
    static void basicGroupingBy(List<Tag> tags) {
        Map<Integer, List<Tag>> map = tags.stream()
            .collect(
                Collectors.groupingBy(tag -> tag.groupId));
        System.out.println(map);
    }
    
    static void groupingByWithDownstream(List<Tag> tags) {
        Map<Integer, List<Integer>> map = tags.stream()
            .collect(Collectors.groupingBy(
                tag -> tag.groupId,
                Collectors.mapping(tag -> tag.id, Collectors.toList())));
        
        System.out.println(map);
    }
    
    static void groupingByWithDownstreamAndSupplier(List<Tag> tags) {
        Map<Integer, List<String>> map = tags.stream()
            .collect(Collectors.groupingBy(
                tag -> tag.groupId,
                LinkedHashMap::new,
                Collectors.mapping(tag -> String.format("%s_%d", tag.name, tag.id), Collectors.toList())));
        
        System.out.println(map);
    }
    
    static class Tag {
    
        int id;
        String name;
        int groupId;

        public Tag(int id, String name, int groupId) {
            this.id = id;
            this.name = name;
            this.groupId = groupId;
        }

        @Override
        public String toString() {
            return "Tag{" + "id=" + id + ", name=" + name + ", groupId=" + groupId + '}';
        }
        
    }
    
}
