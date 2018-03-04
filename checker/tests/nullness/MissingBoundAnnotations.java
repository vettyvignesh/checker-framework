import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.*;

// @skip-test

public final class MissingBoundAnnotations {

    // Test that the upper bound "Comparable<...>" receives an @Unqualified annotation.
    // Otherwise, it fails the check for empty annotations in GraphQualifierHierarchy.
    public static <K extends Comparable<? super K>, V> Collection<@KeyFor("#1") K> sortedKeySet(
            Map<K, V> m) {
        ArrayList<@KeyFor("m") K> theKeys = new ArrayList<@KeyFor("m") K>(m.keySet());
        Collections.sort(theKeys);
        return theKeys;
    }

    public static <K extends Comparable<? super K>, V>
            Collection<@KeyFor("#1") K> sortedKeySetSimpler(ArrayList<@KeyFor("#1") K> theKeys) {
        Collections.sort(theKeys);
        return theKeys;
    }
}
