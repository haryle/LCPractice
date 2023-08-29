from typing import List


class Solution:

    def getBlockID(self, row, col):
        if (row >= 0 and row <= 2):
            if (col >= 0 and col <= 2):
                return 0
            if (col >= 3 and col <= 5):
                return 1
            return 2
        if (row >= 3 and row <= 5):
            if (col >= 0 and col <= 2):
                return 3
            if (col >= 3 and col <= 5):
                return 4
            return 5
        if (col >= 0 and col <= 2):
            return 6
        if (col >= 3 and col <= 5):
            return 7
        return 8

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowDict = [set() for _ in range(9)]
        colDict = [set() for _ in range(9)]
        blockDict = [set() for _ in range(9)]

        for rowID in range(9):
            for colID in range(9):
                num = board[rowID][colID]
                if not (num.isdigit()):
                    continue
                # Check row-wise
                if num in rowDict[rowID]:
                    return False
                rowDict[rowID].add(num)

                # Check column-wise
                if num in colDict[colID]:
                    return False
                colDict[colID].add(num)

                # Check blockwise
                blockID = self.getBlockID(rowID, colID)
                if num in blockDict[blockID]:
                    return False
                blockDict[blockID].add(num)
        return True
