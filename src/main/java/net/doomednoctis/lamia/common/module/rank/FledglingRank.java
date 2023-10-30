package net.doomednoctis.lamia.common.module.rank;

import net.doomednoctis.lamia.api.IVampiricRank;
import net.doomednoctis.lamia.api.VampiricRank;

public class FledglingRank implements IVampiricRank {
    @Override
    public int getMaxBloodLevel() {
        return 8;
    }
}
