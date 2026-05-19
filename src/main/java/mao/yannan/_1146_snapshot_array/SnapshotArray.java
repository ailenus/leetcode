package mao.yannan._1146_snapshot_array;

import java.util.ArrayList;
import java.util.List;

class SnapshotArray {

    List<int[]>[] versions;
    int snapId = 0;

    @SuppressWarnings("unchecked")
    public SnapshotArray(int length) {
        versions = new List[length];
        for (var i = 0; i < length; i++) {
            versions[i] = new ArrayList<>();
            versions[i].add(new int[2]);
        }
    }

    public void set(int index, int val) {
        var version = versions[index];
        var last = version.getLast();
        if (last[0] == snapId) {
            last[1] = val;
        } else {
            version.add(new int[] {snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        var version = versions[index];
        var low = 0;
        var high = version.size() - 1;
        var answer = 0;
        while (low <= high) {
            var mid = (low + high) >>> 1;
            if (version.get(mid)[0] <= snap_id) {
                answer = version.get(mid)[1];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

}
