class Solution {
    int pointer = 0;

    public int lastStoneWeight(int[] stones) {
        pointer = stones.length - 1;
        heapify(stones);
        while (pointer > 0) {
            int i = pointer > 1 && stones[2] > stones[1] ? 2 : 1;
            smash(stones, 0, i);
        }

        return pointer == 0 ? stones[0] : 0;
    }

    private void smash(int[] stones, int i, int j) {
        if (stones[i] == stones[j]) {
            stones[i] = 0;
            stones[j] = 0;
            swap(stones, j, pointer--);
            swap(stones, i, pointer--);
        } else if (stones[i] > stones[j]) {
            stones[i] -= stones[j];
            stones[j] = 0;
            swap(stones, j, pointer--);
        } else {
            stones[j] -= stones[i];
            stones[i] = 0;
            swap(stones, i, pointer--);
        }


        shiftDown(j, stones);
        shiftDown(i, stones);
    }

    private void heapify(int[] stones) {
        int cur = (stones.length) / 2 - 1;
        while (cur >= 0) {
            shiftDown(cur, stones);
            cur--;
        }
    }

    private void shiftDown(int i, int[] stones) {
        while ((2 * i + 1) <= pointer) {
            int left = 2 * i + 1;
            int right = left + 1;
            if (right <= pointer &&
                    stones[right] > stones[left] &&
                    stones[right] > stones[i]) {
                swap(stones, i, right);
                i = right;
            } else if (stones[left] > stones[i]) {
                swap(stones, i, left);
                i = left;
            } else {
                break;
            }
        }
    }

    private void swap(int[] stones, int i, int j) {
        int tmp = stones[i];
        stones[i] = stones[j];
        stones[j] = tmp;
    }

}
