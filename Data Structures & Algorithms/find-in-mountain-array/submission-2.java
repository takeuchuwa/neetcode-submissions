/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        if (length < 3) {
            return -1;
        }

        int iIndex = findMountainIth(mountainArr, length);
        if (mountainArr.get(iIndex) == target) {
            return iIndex;
        }
        int result = searchLeftTarget(target, mountainArr, 0, iIndex - 1);
        return result = result == -1 ? searchRightTarget(target, mountainArr, iIndex + 1, length - 1) : result;
    }

    private int findMountainIth(MountainArray mountainArr, int length) {
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int num = mountainArr.get(middle);
            int prev = -1;
            int next = -1;
            if (middle > 0) {
                prev = mountainArr.get(middle - 1);
            }
            if (middle < length - 1) {
                next = mountainArr.get(middle + 1);
            }

            if (prev < num && num > next) {
                return middle;
            } else if (prev < num && num < next) {
                left = middle + 1;
            } else if (prev > num && num > next) {
                right = middle - 1;
            }
        }

        return -1;
    }

    private int searchLeftTarget(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int num = mountainArr.get(middle);
            if (target > num) {
                left = middle + 1;
            } else if (target < num) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    private int searchRightTarget(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int num = mountainArr.get(middle);
            if (target < num) {
                left = middle + 1;
            } else if (target > num) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}