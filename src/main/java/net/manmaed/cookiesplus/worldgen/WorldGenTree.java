package net.manmaed.cookiesplus.worldgen;

import net.manmaed.cookiesplus.blocks.CookieBlocks;
import net.manmaed.cookiesplus.libs.LogHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by manmaed on 26/02/2019.
 */
public class WorldGenTree implements IWorldGenerator {
    public static WorldGenTree INSTANCE = new WorldGenTree();

    //@formatter:off
    WorldGenAbstractTree orange;
    //@formatter:on

    public WorldGenTree()
    {
        IBlockState log = CookieBlocks.orangeleaf.getDefaultState();
        IBlockState leaves = CookieBlocks.orangelog.getDefaultState();

        this.orange = new GenTree(true);
        }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        this.generateOverworld(random, chunkX, chunkZ, world);
    }

    public void generateOverworld(Random random, int chunkX, int chunkZ, World world)
    {
        int xSpawn, ySpawn, zSpawn;

        int xPos = chunkX * 16 + 8;
        int zPos = chunkZ * 16 + 8;

        BlockPos chunkPos = new BlockPos(xPos, 0, zPos);

        BlockPos position;

        Biome biome = world.getChunk(chunkPos).getBiome(chunkPos, world.getBiomeProvider());

        if (biome == null)
        {
            return;
        }

        if (this.shouldGenerateInDimension(world.provider.getDimension())) {
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)) {
                for (int iter = 0; iter < 3; iter++) {
                    xSpawn = xPos + random.nextInt(16);
                    ySpawn = random.nextInt(5) + 64;
                    zSpawn = zPos + random.nextInt(16);
                    position = new BlockPos(xSpawn, ySpawn, zSpawn);
                    this.orange.generate(world, random, position);
                }
            }
        }
    }

    public boolean shouldGenerateInDimension(int dimension)
    {
            if (dimension != 0)
            {
                return false;
            }
        return true;
    }

}