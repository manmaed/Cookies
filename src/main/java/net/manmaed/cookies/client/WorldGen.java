package net.manmaed.cookies.client;

import net.manmaed.cookies.blocks.CookieBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by manmaed on 26/02/2017.
 */


public class WorldGen implements IWorldGenerator
{

    private WorldGenMinable ginger;


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        int ChunkX16 = chunkX * 16;
        int ChunkZ16 = chunkZ * 16;

        switch (world.provider.getDimension()) {
            case -1:
                GenerateOreInNether(world, random, ChunkX16, ChunkZ16);
                break;
            case 0:
                GenerateOreInOverworld(world, random, ChunkX16, ChunkZ16);
                break;
            case 1:
                GenerateOreInEnd(world, random, ChunkX16, ChunkZ16);
                break;
        }
    }

    public void GenerateOreInEnd(World world, Random random, int X, int Z) {
    }

    public void GenerateOreInOverworld(World world, Random random, int X, int Z) {
        int ChunkX = X + random.nextInt(16);
        int ChunkZ = Z + random.nextInt(16);
            for (int i = 0; i < 16; i++) {
                BlockPos blockPos = new BlockPos(ChunkX, random.nextInt(65), ChunkZ);
                new WorldGenMinable(CookieBlocks.gingerBlock.getDefaultState(), 1)
                        .generate(world, random, blockPos);
            }
    }

    public void GenerateOreInNether(World world, Random random, int X, int Z)
    {
        //   addOreSpawn()
    }
}
